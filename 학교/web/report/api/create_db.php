<?php
$db = new PDO("sqlite:../db/community.db");
$db->exec("CREATE TABLE IF NOT EXISTS posts (author TEXT NOT NULL, title TEXT NOT NULL, content TEXT NOT NULL, created_at TEXT NOT NULL, comments TEXT NOT NULL)");
echo "Database and table created successfully.";