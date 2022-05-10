<?php
session_set_cookie_params(0);
session_start();
require 'database.php';
if (!isset($_SESSION["idBorce"])) {
    header("location: index.php");
}
?>
