<?php
$name =$_POST["username"];

$pass =$_POST["password"];
$reg="/^[a0-z9]{2,5}$/";
if(preg_match($reg,$pass)){
    echo"^_^";
}
else{
    echo"Eror";
}
echo$name."<br>";
echo $pass;

$com=mysqli_connect('localhost','root','root','mohammed');
if(!$com){
echo 'error22222'.mysqli_connect_error();
}else{


if($pass=="123")
{

header("location:Studinfor.html");

}else{
echo"NO passorde ";
}}