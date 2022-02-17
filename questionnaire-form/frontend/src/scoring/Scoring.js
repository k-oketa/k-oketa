import {useState} from "react";
import {FormControl, InputLabel, MenuItem, Select} from "@mui/material";


export default function Scoring(data) {
    const [score, setScore] = useState(1);
    const handleChange = async (event) => {
        setScore(event.target.value);
        await fetch("http://localhost:8080/scoring", {
            method: "POST",
            mode: "cors",
            cache: "no-cache",
            credentials: "same-origin",
            headers: {
                "Content-Type": "application/json"
            },
            redirect: "follow",
            referrerPolicy: "no-referrer",
            body: JSON.stringify(data)
        })
            .then(response => response.json())
            .then(result => console.log(result))
            .catch(error => console.log(error))
    };

    return (
        <FormControl fullWidth>
            <InputLabel id="demo-simple-select-label">Score</InputLabel>
            <Select
                labelId="demo-simple-select-label"
                id="demo-simple-select"
                value={score}
                label="Score"
                onChange={handleChange}
            >
                <MenuItem value={1}>1</MenuItem>
                <MenuItem value={2}>2</MenuItem>
                <MenuItem value={3}>3</MenuItem>
            </Select>
        </FormControl>
    )
}