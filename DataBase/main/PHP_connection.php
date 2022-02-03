<?php

$con = mysqli_connect("localhost", "root", "", "StudyBoard");

if (!$con)
{
    echo "Failed to connect to MySQL: " . mysqli_connect_error();
}

mysqli_set_charset($con, "utf8");

$res = mysqli_query($con, "select * from user");
$result = array();

while($row = mysqli_fetch_array($res)) {

    array_push($result,
        array('userID'=>$row[0], 'userPassword'=>$row[1], 'userName'=>$row[2], 'userAge'=>$row[3]));
}

echo json_encode(array("result"=>$result));

mysqli_close($con);

?>