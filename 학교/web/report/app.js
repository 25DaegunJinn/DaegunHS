const { createApp, ref, onMounted } = Vue;


createApp({
    setup() {
        const author         = ref("");
        const title          = ref("");
        const content        = ref("");
        const posts          = ref([]);
        const popupTitle     = ref("");
        const popupAuthor    = ref("");
        const popupContent   = ref("");
        const comments       = ref([]);
        const isPopupVisible = ref(false);
        
        fetch("api/create_db.php");
        
        
        const fetchPosts = async () => {
            const res = await fetch("api/get_posts.php");
            posts.value = await res.json();
            console.log(posts.value);
        };

        const addPost = async () => {
            let exists = {
                author: true,
                title: true,
                content: true
            }
            if(!author.value || author.value.trim().length === 0)
                exists.author = false;
            if(!title.value || title.value.trim().length === 0)
                exists.title = false;
            if(!content.value || content.value.trim().length === 0)
                exists.content = false;

            if(!exists.author)
                return alert("Please Input Author.");
            if(!exists.title)
                return alert("Please Input Title.")
            if(!exists.content)
                return alert("Please Input Content.");
            
            const form = new FormData();
            
            form.append("author",  author.value);
            form.append("title",   title.value);
            form.append("content", content.value);
            
            await fetch("api/add_post.php", {
                method: "POST",
                body: form
            });

            author.value  = "";
            title.value   = "";
            content.value = "";
            fetchPosts();
        };

        const popupPost = async (title, author, content, comments) => {
            popupTitle.value = title;
            popupAuthor.value = author;
            popupContent.value = content.replace(/\n/g, '<br/>');
            comments.value = JSON.parse(comments);
            isPopupVisible.value = true;
        }

        const closePopup = () => {
            isPopupVisible.value = false;
        }

        onMounted(() => {
            fetchPosts();
        });

        return { author, content, posts, fetchPosts, addPost, popupTitle, popupAuthor, popupContent, comments, popupPost, isPopupVisible, title, closePopup };
    }
}).mount("#app")