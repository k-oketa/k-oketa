import {InputLabel, Stack, TextField} from "@mui/material";
import DynamicOptionField from "./DynamicOptionField";


export default function QuestionContents(props) {
    if (props.type === "singleChoice") {
        return (
            <Stack spacing={2}>
                <InputLabel>選択肢</InputLabel>
                <DynamicOptionField type={"singleChoice"} control={props.control} questionOrdinal={props.questionOrdinal} />
            </Stack>
        )
    } else if (props.type === "multipleChoice") {
        return (
            <Stack spacing={2}>
                <InputLabel>選択肢</InputLabel>
                <DynamicOptionField type={"multipleChoice"} control={props.control} questionOrdinal={props.questionOrdinal} />
            </Stack>
        )
    } else if (props.type === "description") {
        return (
            <Stack spacing={2}>
                <InputLabel>入力欄（回答用につき入力不要）</InputLabel>
                <TextField multiline disabled variant="filled" fullWidth rows={4} questionOrdinal={props.questionOrdinal} />
            </Stack>
        )
    } else if (props.type === "singleChoiceAndDescription") {
        return (
            <Stack spacing={2}>
                <InputLabel>選択肢</InputLabel>
                <DynamicOptionField type={"singleChoice"} control={props.control} questionOrdinal={props.questionOrdinal} />
                <InputLabel>入力欄（回答用につき入力不要）</InputLabel>
                <TextField multiline disabled variant="filled" fullWidth rows={4} />
            </Stack>
        )
    }
}