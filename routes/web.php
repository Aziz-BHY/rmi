<?php

use Illuminate\Support\Facades\Route;
use Illuminate\Support\Facades\Request;

Route::get('/employe', function () {
    $results = DB::select('select * from Employe;');
    return $results;
});

Route::get('/employe/{id}', function ($id) {
    $results = DB::select('select * from Employe where id = ?', array($id));
    return $results;
});

Route::post('/employe', function () {
    $id = Request::get('id');
    $nom = Request::get('nom');
    $prenom = Request::get('prenom');
    $adresse = Request::get('adresse');
    $grade = Request::get('grade');
    $numCompte = Request::get('numCompte');
    $idSup = Request::get('idSup');

    DB::insert('insert into Employe (id, nom, prenom, adresse, grade, numCompte, idSup ) values(?,?,?,?,?,?,?)', array($id, $nom, $prenom, $adresse, $grade, $numCompte, $idSup));
    return "Employe added";
});

Route::put('/employe/{id}', function ($id) {
    $nom = Request::get('nom');
    $prenom = Request::get('prenom');
    $adresse = Request::get('adresse');
    $grade = Request::get('grade');
    $numCompte = Request::get('numCompte');
    $idSup = Request::get('idSup');
    DB::insert('update Employe set nom=?, prenom=?, adresse=?, grade=?, numCompte=?, idSup=? where id = ?', array($nom, $prenom, $adresse, $grade, $numCompte, $idSup, $id));
    return "Employe updated";
});

Route::delete('/employe/{id}', function ($id) {
    DB::delete('delete from Employe where id = ?', array($id));
    return "Employe deleted";
});


Route::get('/tache', function () {
    $results = DB::select('select * from Tache;');
    return $results;
});

Route::get('/tache/{id}', function ($id) {
    $results = DB::select('select * from Tache where id = ?', array($id));
    return $results;
});

Route::post('/tache', function () {
    $id = Request::get('id');
    $description = Request::get('description');
    $idEmploye = Request::get('idEmploye');

    DB::insert('insert into Tache (id, description, idEmploye) values(?,?,?)', array($id, $description, $idEmploye));
    return "Tache added";
});

Route::put('/tache/{id}', function ($id) {
    $description = Request::get('description');
    $idEmploye = Request::get('idEmploye');
    DB::insert('update Tache set description=?, idEmploye=? where id = ?', array($description, $idEmploye, $id));
    return "Tache updated";
});

Route::delete('/tache/{id}', function ($id) {
    DB::delete('delete from Tache where id = ?', array($id));
    return "Tache deleted";
});

