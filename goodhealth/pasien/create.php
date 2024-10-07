<?php

include '../db.php';

$response = null;

try {
    if ($_SERVER['REQUEST_METHOD'] == 'POST') {
        $data = json_decode(file_get_contents('php://input'));
        $nama = $data->nama ?? "";
        $hp = $data->hp ?? "";
        $email = $data->email ?? "";

        $query_pasien = "INSERT INTO pasien (nama, hp, email) VALUES (?, ?, ?)";
        $query_user = "INSERT INTO user (username, password, id_pasien) VALUES (?, ?, ?)";

        $conn->beginTransaction();

        $stmt_pasien = $conn->prepare($query_pasien);
        $stmt_user = $conn->prepare($query_user);
        $stmt_pasien->execute([$nama, $hp, $email]);
        $stmt_user->execute([$hp, sha1($hp), $conn->lastInsertId()]);
        $conn->commit();
        $response['message'] = "Successful! please login using your phone number as username and password";
    }
} catch (Exception $e) {
    if ($conn->inTransaction()) {
        $conn->rollBack();
    }
    $response['message'] = "Gagal: " . $e->getMessage();
}

echo json_encode($response);