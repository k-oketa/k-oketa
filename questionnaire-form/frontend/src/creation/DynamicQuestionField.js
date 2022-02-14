import {useFieldArray, useForm, Controller} from "react-hook-form";
import {Button, Card, CardActions, CardContent, IconButton, Input, InputLabel, Stack} from "@mui/material";
import {Add, ArrowDownward, ArrowUpward, Delete} from "@mui/icons-material";
import QuestionContents from "./QuestionContents";


export default function DynamicQuestionField(props) {
    const { fields, append, remove, swap } = useFieldArray({
        control: props.control,
        name: "questions"
    });

    return (
        <Stack spacing={3}>
            {fields.map((field, questionOrdinal) => (
                <Card key={field.id}>
                    <CardContent>
                        <Stack spacing={2}>
                            <InputLabel>質問文</InputLabel>
                            <Controller
                                name={`questions.${questionOrdinal}.body`}
                                control={props.control}
                                render={({ field }) => <Input fullWidth {...field} />}
                            />
                            <QuestionContents type={field.type} control={props.control} questionOrdinal={questionOrdinal} />
                        </Stack>
                    </CardContent>
                    <CardActions disableSpacing>
                        <IconButton onClick={() => swap(questionOrdinal - 1, questionOrdinal)}><ArrowUpward /></IconButton>
                        <IconButton onClick={() => swap(questionOrdinal, questionOrdinal + 1)}><ArrowDownward /></IconButton>
                        <IconButton onClick={() => remove(questionOrdinal)}><Delete /></IconButton>
                    </CardActions>
                </Card>
            ))}
            <Stack direction="row" spacing={2}>
                <Button variant="outlined" startIcon={<Add />} onClick={() => {append(defaultSingleChoice())}}>単一選択形式</Button>
                <Button variant="outlined" startIcon={<Add />} onClick={() => {append(defaultMultipleChoice())}}>複数選択形式</Button>
                <Button variant="outlined" startIcon={<Add />} onClick={() => {append(defaultDescription())}}>記述形式</Button>
                <Button variant="outlined" startIcon={<Add />} onClick={() => {append(defaultSingleChoiceAndDescription())}}>選択記述形式</Button>
            </Stack>
        </Stack>
    )

    function defaultSingleChoice() {
        return { body: "", type: "singleChoice", contents: { options: [] } }
    }

    function defaultMultipleChoice() {
        return { body: "", type: "multipleChoice", contents: { options: [] } }
    }

    function defaultDescription() {
        return { body: "", type: "description", contents: {} }
    }

    function defaultSingleChoiceAndDescription() {
        return { body: "", type: "singleChoiceAndDescription", contents: { options: [] } }
    }
}