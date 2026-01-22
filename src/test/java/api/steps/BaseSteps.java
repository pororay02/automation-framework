package api.steps;

import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;
import static io.restassured.RestAssured.given;

public class BaseSteps {
    // Kita tetap pakai static agar semua file steps bisa melihat response yang sama
    public static Response response;

    protected RequestSpecification getRequestSpec() {
        // Ambil APP_ID dari terminal (-DAPP_ID=...)
        String appId = System.getProperty("APP_ID");

        // Fallback jika lupa input di terminal
        if (appId == null || appId.isEmpty()) {
            appId = "6112dc7c3f812e0d9b6679dd";
        }

        return given()
                .header("app-id", appId)
                .contentType("application/json")
                .log().all(); // Tambah log biar kita bisa liat request di terminal
    }
}