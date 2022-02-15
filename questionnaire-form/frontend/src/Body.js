import {Container} from "@mui/material";
import SurveyCreation from "./creation/SurveyCreation";


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
        }
    }
}