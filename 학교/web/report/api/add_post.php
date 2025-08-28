<?php
$author = $_POST["author"];
$content = $_POST["content"];
$title = $_POST["title"];

$db = new PDO("sqlite:../db/community.db");

$stmt = $db->prepare("INSERT INTO posts (title, author, content, created_at, comments) VALUES (:title, :author, :content, :created_at, :comments)");
$stmt->bindParam(":title", $title);
$stmt->bindParam(":author", $author);
$stmt->bindParam(":content", $content);
$stmt->bindParam(":created_at", date('Y-m-d H:i:s'));
$stmt->bindParam(":comments", json_encode([]));
$stmt->execute();
echo "Post added successfully.";