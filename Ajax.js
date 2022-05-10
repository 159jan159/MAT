//Lepší ajax
fetch("DBwork.php", {
        method: "POST",
        body: JSON.stringify({ 
            ver: 1,
            postava: 0,
            monster: 0
        })
      })
    .then((res)=>res.json())
    .then(response => {
        $("#gold").text("");
        $("#gold").text(response[0].zlato);    
        $("#xp").text("");
        $("#xp").text(response[0].voda);    
    }).catch(error => console.log(error));

//Připojení db (ten require db.php je tohle)
$mysqli= new mysqli("localhost", "root", "", "gamergaming");
        $mysqli->query("Set names utf8");
        if ($mysqli->connect_error) {
            echo $mysqli->connect_error;
            return;
        }

//ten fetch jde do tohohle a tím $data->jmeno ziskas co jsi poslal tim jsonem
require 'database.php';
session_start();
$json = file_get_contents('php://input');
$data = json_decode($json);

$ver = $data->ver;
$postava = $data->postava;
