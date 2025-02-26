let starts=document.getElementById('stars1');
let moon2=document.getElementById('moon3');
let mountains3=document.getElementById('mountains3');
let mountains4=document.getElementById('mountains4');
let river5=document.getElementById('river5');
let boat6=document.getElementById('boat6');
window.onscroll=function(){

    let Value=scrollY;
    console.log(Value);
   starts.style.left=Value +'px';

   moon2.style.top=Value*3 +'px';
   mountains3.style.top=Value *1.2+'px';

   mountains4.style.top=Value *1.5+'px';
   river5.style.top=Value +'px';
   boat6.style.top=Value +'px';
   boat6.style.left=Value*3 +'px';
   if(scrollY >= 122){
document.querySelector('.Main').style.background='#4448cc';
    
   }
   else{
    document.querySelector('.Main').style.background='#200016';
   }
}


