//for å legge til tabellen for registeret på åpning uten jQuery
document.addEventListener('DOMContentLoaded', function() {
    document.getElementById("billettRegister").innerHTML += baseFormat;
})


function checkValid() {
    const feilmeldingArray = document.getElementsByClassName("feilmelding");
    for (let melding of feilmeldingArray)
        melding.innerHTML = "";

    const antallStr = document.getElementById("antall").value;
    const antall = Number(antallStr);

    let valid = true;
    if (document.getElementById("dropMenu").value === "") {
        valid = false;
        document.getElementById("feilmeldingFilm").innerHTML = "Legg inn en film.";
    }
    if (antall === 0) {
        valid = false;
        document.getElementById("feilmeldingAntall").innerHTML = "Skriv et antall over 0.";
    }
    if (document.getElementById("fornavn").value === "") {
        valid = false;
        document.getElementById("feilmeldingFor").innerHTML = "Skriv fornavn inn.";
    }
    if (document.getElementById("etternavn").value === "") {
        valid = false;
        document.getElementById("feilmeldingEtter").innerHTML = "Skriv etternavn inn.";
    }
    if (document.getElementById("tlfnr").value === "") {
        valid = false;
        document.getElementById("feilmeldingTlf").innerHTML = "Skriv telefonnummeret inn.";
    }
    if (document.getElementById("epost").value === "") {
        valid = false;
        document.getElementById("feilmeldingEpost").innerHTML = "Skriv e-posten din inn.";
    }
    if (valid === true) {
        registrerBillett();
    }
}

function registrerBillett() {
    const billett = {
        filmNavn: $("#dropMenu").val(),
        antall: $("#antall").val(),
        fornavn: $("#fornavn").val(),
        etternavn: $("#etternavn").val(),
        tlfnr: $("#tlfnr").val(),
        epost: $("#epost").val()
    }
    $.post("/lagre", billett, function () {
        hentBilletter();
    })

    const inputBokser = document.getElementsByClassName("innVerdi");
    for (const inputboks of inputBokser) {
        inputboks.value = "";
    }
}

function hentBilletter() {
    $.get("/hentBilletter", function (data) {
        visData(data);
    })}

let baseFormat = "<table class='table table-striped table-bordered table-hover col'><tr>" +
    "<th>Film</th>" +
    "<th>Antall</th>" +
    "<th>Fornavn</th>" +
    "<th>Etternavn</th>" +
    "<th>Telefonnummer</th>" +
    "<th>E-post</th>" +
    "<th></th>" +
    "</tr>";

function visData (billetter) {
    let utBillett = "";
    for (const billett of billetter) {
        utBillett += "<tr>" +
            "<td>" + billett.filmNavn + "</td>" +
            "<td>" + billett.antall + "</td>" +
            "<td>" + billett.fornavn + "</td>" +
            "<td>" + billett.etternavn + "</td>" +
            "<td>" + billett.tlfnr + "</td>" +
            "<td>" + billett.epost + "</td>" +
            "<td> <button class='btn btn-danger rounded-5' onclick='slettBillett("+billett.id+")'>Slett</button></td>" +
            "</tr>"
    }
    utBillett += "</table>"
    $("#billettRegister").html(baseFormat + utBillett);
}

function slettRegister() {
    $.get("/slettBilletter", function () {
        hentBilletter();
    })
}


function slettBillett (id) {
    const url = "/slettEnkelt?id=" + id
    $.post(url, function () {
        hentBilletter();
    })
}
