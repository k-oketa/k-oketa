import {Container} from "@mui/material";
import SurveyCreation from "./creation/SurveyCreation";


export default function Body() {
    return (
        <Container maxWidth="xl">
            <Container maxWidth="md">
                <SurveyCreation />
            </Container>
        </Container>
    )
}