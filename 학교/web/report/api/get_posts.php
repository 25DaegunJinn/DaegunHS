<?php
$db = new PDO("sqlite:../db/community.db");

$stmt = $db-> query("SELECT * FROM posts");
$posts = $stmt->fetchAll(PDO::FETCH_ASSOC);

header("Content-Type: application/json; charset=utf-8");
echo json_encode($posts, JSON_UNESCAPED_UNICODE | JSON_PRETTY_PRINT);