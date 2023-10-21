function ff(){
    document.getElementById("f1").style.display="flex"
    document.getElementById("fn").style.outline="none";
    document.getElementById("fn").style.border="none";
    document.getElementById("fn").removeAttribute("placeholder")
}
function fo(){
    document.getElementById("f1").style.display="none"
    document.getElementById("fn").style.outline="flex";
    document.getElementById("fn").style.border="flex";
    document.getElementById("fn").setAttribute("placeholder","Full name")
    document.getElementById("f2").style.display="none"
    document.getElementById("en").style.outline="flex";
    document.getElementById("en").style.border="flex";
    document.getElementById("en").setAttribute("placeholder","Email")
    document.getElementById("f3").style.display="none"
    document.getElementById("nn").style.outline="flex";
    document.getElementById("nn").style.border="flex";
    document.getElementById("nn").setAttribute("placeholder","Phone")
    document.getElementById("f4").style.display="none"
    document.getElementById("pn").style.outline="flex";
    document.getElementById("pn").style.border="flex";
    document.getElementById("pn").setAttribute("placeholder","password")
}
function ff2(){
    document.getElementById("f2").style.display="flex"
    document.getElementById("en").style.outline="none";
    document.getElementById("en").style.border="none";
    document.getElementById("en").removeAttribute("placeholder")
}
function ff3(){
    document.getElementById("f3").style.display="flex"
    document.getElementById("nn").style.outline="none";
    document.getElementById("nn").style.border="none";
    document.getElementById("nn").removeAttribute("placeholder")
}
function ff4(){
    document.getElementById("f4").style.display="flex"
    document.getElementById("pn").style.outline="none";
    document.getElementById("pn").style.border="none";
    document.getElementById("pn").removeAttribute("placeholder")
}

