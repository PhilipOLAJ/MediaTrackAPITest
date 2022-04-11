package stepdef;

import contextInjection.MediaInjection;
import model.MediaModel;
import pages.APIMethod;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;

import java.util.ArrayList;
import java.util.List;

public class MyStepdefs extends APIMethod {
    APIMethod apiMethod = new APIMethod();
    MediaInjection mediaInjection = new MediaInjection();

    @When("i do a get request for media")
    public void iDoAGetRequestForMedia() {
        apiMethod.GetMethod();
    }

    @Then("status code is returned")
    public void statusCodeIsReturned() {
        Assert.assertTrue(apiMethod.GetMethod().getStatusCode() == 200);
    }

    @And("response time of the request is below {int} milliseconds")
    public void responseTimeOfTheRequestIsBelowMilliseconds(int seconds) {
        Assert.assertTrue(apiMethod.GetMethod().getTime() < seconds);
    }


    @Then("verify ID field is not null in all the tracks")
    public void verifyIDFieldIsNotNullInAllTheTracks() {
        mediaInjection.response = apiMethod.GetMethod();
        mediaInjection.mediaModels = (List<MediaModel>) mediaInjection.response.jsonPath().get("data");
        List<MediaModel> error = new ArrayList<>();
        for (var item : mediaInjection.mediaModels
        ) {
            if (item.id != "") {
                Assert.fail(String.valueOf(error.add(item)));
            }
        }

    }

    @And("Segment type field has music as value")
    public void segmentTypeFieldHasMusicAsValue() {
        mediaInjection.response = apiMethod.GetMethod();
        mediaInjection.mediaModels = (List<MediaModel>) mediaInjection.response.jsonPath().get("data");
        List<MediaModel> musicList = new ArrayList<>();
        for (var item : mediaInjection.mediaModels
        ) {
            if (item.segment_type != "music") {
                Assert.fail(String.valueOf(musicList.add(item)));
                break;

            }

        }

    }

    @Then("primary field in title_list is never null")
    public void primaryFieldInTitle_listIsNeverNull() {
        mediaInjection.response = apiMethod.GetMethod();
        mediaInjection.mediaModels = (List<MediaModel>) mediaInjection.response.jsonPath().get("data");
        List<MediaModel> primaryList = new ArrayList<>();
        for (var item : mediaInjection.mediaModels
        ) {
            if (item.titleList.primary == null) {
                Assert.fail(String.valueOf(primaryList.add(item)));
                break;
            }

        }
    }

    @Then("only one track in the list has “now_playing” field in “offset” as true")
    public void onlyOneTrackInTheListHasNow_playingFieldInOffsetAsTrue() {
        mediaInjection.response = apiMethod.GetMethod();
        mediaInjection.mediaModels = (List<MediaModel>) mediaInjection.response.jsonPath().get("data");
        List<MediaModel> primaryList = new ArrayList<>();
        for (var item : mediaInjection.mediaModels
        ) {
            if (item.offSet.now_playing == true) {
                Assert.assertTrue(primaryList.add(item));
                break;
            }

        }
    }
}
