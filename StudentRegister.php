<?php
$name=htmlspecialchars( $_POST["StudentName"]);
$password=htmlspecialchars($_POST["StudentPhone"]);
echo "<br>";
echo $name;
echo "<br>";
echo $password;  
echo "<br>";


$con=mysqli_connect('localhost','root','root','mohammed');
if(!$con){
    echo "False";
        echo "Error Connection ".mysqli_connect_erroe();
    
    }else{


$query="insert into Student(StudentName,StudentPhone) values('$name','$password')";
mysqli_query($con,$query);


    }

echo "Adding Student Successfuly";




