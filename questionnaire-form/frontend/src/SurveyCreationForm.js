import {useForm, Controller, useFieldArray} from "react-hook-form";
import {
    Box,
    Button,
    Card, CardActions,
    CardContent, IconButton,
    Input, InputLabel, Stack,
    TextField
} from "@mui/material";

import {Add, ArrowDownward, ArrowUpward, Delete} from "@mui/icons-material";

function HookedInput(props) {
    return (
        <div>
            <InputLabel>{props.label}</InputLabel>
            <Controller
                name={`appended.${props.title}`}
                control={props.control}
                render={({ field }) => <Input fullWidth {...field} />}
            />
        </div>
    )
}

export default function SurveyCreationForm() {
    const {control, handleSubmit} = useForm({
        defaultValues: {
            title: '',
            agreementBody: '',
            questions: []
        }
    });
    const {fields, append, prepend, remove, swap, move, insert} = useFieldArray({
        control,
        name: "questions"
    });
    const onSubmit = data => console.log(data);

    function appendFormCard(field) {
        if (field.questionType === "singleChoice") {
            return (
                <CardContent>
                    <Stack spacing={1}>
                        <HookedInput title={field.id} control={control} label={'質問文'} />
                        <InputLabel>選択肢</InputLabel>
                    </Stack>
                </CardContent>
            )
        } else if (field.questionType === "multipleChoice") {
            return (
                <CardContent>
                    <Stack spacing={1}>
                        <HookedInput title={field.id} control={control} label={'質問文'} />
                        <InputLabel>複数選択肢</InputLabel>
                    </Stack>
                </CardContent>
            )
        } else if (field.questionType === "description") {
            return (
                <CardContent>
                    <Stack spacing={1}>
                        <HookedInput title={field.id} control={control} label={'質問文'} />
                        <TextField multiline disabled variant="filled" fullWidth rows={4} />
                    </Stack>
                </CardContent>
            )
        } else if (field.questionType === "singleChoiceAndDescription") {
            return (
                <CardContent>
                    <Stack spacing={1}>
                        <HookedInput title={field.id} control={control} label={'質問文'} />
                        <InputLabel>選択肢</InputLabel>
                        <TextField multiline disabled variant="filled" fullWidth rows={4} />
                    </Stack>
                </CardContent>
            )
        }
     }

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <Stack spacing={2}>
                <Card variant="outlined">
                    <CardContent>
                        <Stack spacing={2}>
                            <HookedInput title={'title'} control={control} label={'調査の名称'} />
                            <HookedInput title={'agreementBody'} control={control} label={'調査の規約'} />
                        </Stack>
                    </CardContent>
                </Card>
                {fields.map((field, index) => (
                    <Card key={field.id}>
                        {appendFormCard(field)}
                        <CardActions disableSpacing>
                            <IconButton onClick={() => swap(index - 1, index)}><ArrowUpward /></IconButton>
                            <IconButton onClick={() => swap(index, index + 1)}><ArrowDownward /></IconButton>
                            <IconButton onClick={() => remove(index)}><Delete /></IconButton>
                        </CardActions>
                    </Card>
                ))}
                <Stack direction="row" spacing={2}>
                        <Button variant="outlined" startIcon={<Add />} onClick={() => {append({questionType: "singleChoice"})}}>単一選択形式</Button>
                        <Button variant="outlined" startIcon={<Add />} onClick={() => {append({questionType: "multipleChoice"})}}>複数選択形式</Button>
                        <Button variant="outlined" startIcon={<Add />} onClick={() => {append({questionType: "description"})}}>記述形式</Button>
                        <Button variant="outlined" startIcon={<Add />} onClick={() => {append({questionType: "singleChoiceAndDescription"})}}>単一選択&記述形式</Button>
                </Stack>
                <Button variant="contained" size="large" type="submit">この内容で作成する</Button>
            </Stack>
            <Box sx={{ height: 200 }} />
        </form>
    )
}