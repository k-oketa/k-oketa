import { useForm, Controller } from "react-hook-form";
import {Button, Input, MenuItem, Select} from "@mui/material";

export default function UILibraryForm() {
    const { control, handleSubmit } = useForm({
        defaultValues: {
            firstName: '',
            select: ''
        }
    });
    const onSubmit = data => console.log(data);

    return (
        <form onSubmit={handleSubmit(onSubmit)}>
            <Controller
                name="firstName"
                control={control}
                render={({ field }) => <Input {...field} />}
            />
            <Controller
                name="select"
                control={control}
                render={({ field }) => <Select {...field}>
                    <MenuItem value={"chocolate"}>Chocolate</MenuItem>
                    <MenuItem value={"strawberry"}>Strawberry</MenuItem>
                    <MenuItem value={"vanilla"}>Vanilla</MenuItem>
                </Select>}
            />
            <Button type="submit">送信</Button>
        </form>
    )
}