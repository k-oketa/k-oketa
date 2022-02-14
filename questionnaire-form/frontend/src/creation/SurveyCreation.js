import {useForm, Controller} from "react-hook-form";
import {Box, Button, Card, CardContent, Input, InputLabel, Stack, TextField} from "@mui/material";
import DynamicQuestionField from "./DynamicQuestionField";
import {CheckBox} from "@mui/icons-material";


export default function SurveyCreation() {
    const { control, handleSubmit } = useForm(({
        defaultValues: {
            title: "",
            agreementBody: "",
            questions: []
        }
    }));
    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <Stack spacing={3}>
                <Card variant="outlined">
                    <CardContent>
                        <Stack spacing={2}>
                            <InputLabel>調査の名称</InputLabel>
                            <Controller
                                name="title"
                                control={control}
                                render={({ field }) => <Input fullWidth {...field} />}
                            />
                            <InputLabel>調査の規約</InputLabel>
                            <Controller
                                name="agreementBody"
                                control={control}
                                render={({ field }) => <TextField multiline fullWidth rows={2} />}
                            />
                            <Stack spacing={2} direction="row">
                                <CheckBox />
                                <InputLabel>上記の規約に同意する</InputLabel>
                            </Stack>
                        </Stack>
                    </CardContent>
                </Card>
                <DynamicQuestionField control={control} />
                <Button variant="contained" type="submit">この内容で作成する</Button>
            </Stack>
            <Box sx={{ height: 200 }} />
        </form>
    )
}