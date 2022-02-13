import {Container} from "@mui/material";
import SurveyCreationForm from "./SurveyCreationForm";


export default function Body() {
    return (
        <Container maxWidth="xl">
            <Container maxWidth="md">
                <SurveyCreationForm />
            </Container>
        </Container>
    )
}