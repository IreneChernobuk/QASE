package apitests;

import constants.Urls;
import io.qameta.allure.Description;
import io.qameta.allure.Feature;
import io.qameta.allure.Severity;
import io.qameta.allure.SeverityLevel;
import io.restassured.response.ValidatableResponse;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;
import utils.FakerMessageGenerator;
import utils.TestListeners;

import static io.restassured.RestAssured.given;
import static org.hamcrest.Matchers.notNullValue;
import static org.hamcrest.core.IsEqual.equalTo;

@Feature("Api tests")
@Listeners(TestListeners.class)
public class ApiTest {
    int id;
    int idDefect;

    @Test
    @Description("Getting all test case in 'API Project'")
    @Severity(SeverityLevel.NORMAL)
    public void getTestCaseTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        given()
                .when()
                .get(Urls.CASE)
                .then().log().all()
                .body("result.count", notNullValue());
    }

    @Test
    @Description("Check that the author with value 'idAuthor' exists in 'API Project'")
    @Severity(SeverityLevel.NORMAL)
    public void existAuthorTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        int idAuthor = 106501;
        given()
                .when()
                .get(Urls.AUTHOR + idAuthor)
                .then().log().all()
                .body("result.id", equalTo(idAuthor));
    }

    @Test
    @Description("Getting all projects")
    @Severity(SeverityLevel.NORMAL)
    public void getAllProjectsTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        given()
                .when()
                .get(Urls.PROJECT)
                .then().log().all()
                .body("result.total", notNullValue());
    }

    @Test
    @Description("Creating test case in 'API Project' and get id current test case")
    @Severity(SeverityLevel.CRITICAL)
    public void createTestCaseTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        Model testCase = Model
                .builder()
                .title(FakerMessageGenerator.generateTitle())
                .description(FakerMessageGenerator.generateText())
                .severity(FakerMessageGenerator.generateSeverity())
                .priority(FakerMessageGenerator.generatePriority())
                .build();
        ValidatableResponse authorResponse = given()
                .body(testCase)
                .when()
                .post(Urls.CASE)
                .then();
        id = authorResponse.extract().path("result.id");
        authorResponse.body("status", equalTo(true));
    }

    @Test(dependsOnMethods = "createTestCaseTest")
    @Description("Updating the data in specific test case in 'API Project'")
    @Severity(SeverityLevel.NORMAL)
    public void updateTestCaseTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        Model testCase = Model
                .builder()
                .title(FakerMessageGenerator.generateTitle())
                .description(FakerMessageGenerator.generateText())
                .priority(FakerMessageGenerator.generatePriority())
                .severity(FakerMessageGenerator.generatePriority())
                .build();
        given()
                .body(testCase)
                .when()
                .patch(Urls.CASE + id)
                .then().log().all()
                .body("status", equalTo(true));
    }

    @Test(dependsOnMethods = {"createTestCaseTest", "updateTestCaseTest"})
    @Description("Specific test case delete in 'API Project'")
    @Severity(SeverityLevel.CRITICAL)
    public void deleteTestCaseTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        given()
                .when()
                .delete(Urls.CASE + id)
                .then().log().all()
                .body("result.id", equalTo(id));
    }

    @Test
    @Description("Creating new project")
    @Severity(SeverityLevel.BLOCKER)
    public void createProjectTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        Model testCase = Model
                .builder()
                .title(FakerMessageGenerator.generateTitle())
                .code(FakerMessageGenerator.generateCodeForProject())
                .description(FakerMessageGenerator.generateTitle())
                .build();
        given()
                .body(testCase)
                .when()
                .post(Urls.PROJECT)
                .then().log().all()
                .body("result.code", equalTo(testCase.getCode().toUpperCase()));
    }

    @Test
    @Description("Creating new defect in 'API Project'")
    @Severity(SeverityLevel.CRITICAL)
    public void createNewDefectTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        DefectModal defect = DefectModal
                .builder()
                .title(FakerMessageGenerator.generateTitle())
                .actual_result(FakerMessageGenerator.generateText())
                .severity(FakerMessageGenerator.generateSeverity())
                .build();
        ValidatableResponse defectResponse = given()
                .body(defect)
                .when()
                .post(Urls.DEFECT)
                .then().log().all();
        idDefect = defectResponse.extract().path("result.id");
        defectResponse.body("status", equalTo(true));
    }

    @Test(dependsOnMethods = "createNewDefectTest")
    @Description("Check that the defect with value 'idDefect' exists in 'API Project'")
    @Severity(SeverityLevel.NORMAL)
    public void getSpecificDefectTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        given()
                .when()
                .get(Urls.DEFECT + idDefect)
                .then().log().all()
                .body("result.id", equalTo(idDefect));
    }

    @Test(dependsOnMethods = "createNewDefectTest")
    @Description("This method allows to resolve a specific defect in 'API Project'")
    @Severity(SeverityLevel.CRITICAL)
    public void resolveSpecificDefectTest() {
        Specifications.installSpecification(Specifications.requestSpec(), Specifications.responseSpecOK200());
        given()
                .when()
                .patch(Urls.DEFECT_RESOLVE + idDefect)
                .then().log().all()
                .body("status", equalTo(true))
                .body("result.id", equalTo(idDefect));
    }
}