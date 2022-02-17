import {Container} from "@mui/material";
import SurveyCreation from "./creation/SurveyCreation";
import Scoring from "./scoring/Scoring";


export default function Body(props) {
    return (
        <Container maxWidth="xl">
            <Container maxWidth="md">
                {page(props.mode)}
            </Container>
        </Container>
    )

    function page(mode) {
        if (mode === "creation") {
            return <SurveyCreation />
        } else if (mode === "answer") {
            // return <SurveyAnswer />
        } else if (mode === "scoring") {
            return <Scoring />
        }
    }
}