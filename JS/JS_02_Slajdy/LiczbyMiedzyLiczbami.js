/**
 * Created by tomek on 20.04.2017.
 */
function wypisz() {
    var liczba1 = document.getElementById("pole1").value;
    var liczba2 = document.getElementById("pole2").value;
    var napis = "";

    for(i=liczba1;i<=liczba2;i++)
    {
        napis+=" "+ i;
    }
    document.getElementById("wynik").innerHTML = napis;
}