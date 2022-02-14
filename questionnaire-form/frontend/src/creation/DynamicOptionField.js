import {useFieldArray, Controller} from "react-hook-form";
import {IconButton, Input, List, ListItem, ListItemButton, ListItemIcon, ListItemText} from "@mui/material";
import {Add, CheckBox, Clear, RadioButtonChecked} from "@mui/icons-material";


export default function DynamicOptionField(props) {
    const { fields, append, remove } = useFieldArray({
        control: props.control,
        name: `questions.${props.questionOrdinal}.contents.options`
    });

    return (
        <List>
            {fields.map((field, index) => (
                <ListItem disablePadding key={field.id}>
                    <ListItemIcon>{choiceIcon(props.type)}</ListItemIcon>
                    <Controller
                        name={`questions.${props.questionOrdinal}.contents.options.${index}.body`}
                        control={props.control}
                        render={({ field }) => <Input fullWidth {...field} /> }
                    />
                    <IconButton onClick={() => remove(index)}><Clear /></IconButton>
                </ListItem>
            ))}
            <ListItemButton disablePadding onClick={() => append({ body: "" })}>
                <ListItemIcon><Add /></ListItemIcon>
                <ListItemText>選択肢を追加</ListItemText>
            </ListItemButton>
        </List>
    )

    function choiceIcon(type) {
        if (type === "singleChoice") {
            return <RadioButtonChecked />
        } else if (type === "multipleChoice") {
            return <CheckBox />
        }
    }


}