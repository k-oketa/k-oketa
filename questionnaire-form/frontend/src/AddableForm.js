import {useFieldArray, useForm, Controller} from "react-hook-form";
import {Button, List, ListItem} from "@mui/material";

export default function AddableForm() {
    const { control, handleSubmit } = useForm();
    const { fields, append, prepend, remove, swap, move, insert } = useFieldArray({
        control, // control props comes from useForm (optional: if you are using FormContext)
        name: "test", // unique name for your Field Array
        // keyName: "id", default to "id", you can change the key name
    });
    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <List>
                {fields.map((field, index) => {
                    return (
                        <Controller
                            name={index}
                            control={control}
                            render={({field}) => <ListItem>a</ListItem>}
                        />
                    )
                })}
            </List>
            <Button onClick={() => append({})} type="submit">追加</Button>
        </form>
    );
}