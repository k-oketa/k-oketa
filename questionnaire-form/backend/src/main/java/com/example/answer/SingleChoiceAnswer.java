package com.example.answer;

import lombok.EqualsAndHashCode;

import java.io.Serial;
import java.io.Serializable;

@EqualsAndHashCode
public class SingleChoiceAnswer extends Answer<Integer> implements Serializable {

    @Serial
    private static final long serialVersionUID = -2233874049953316060L;

    SingleChoiceAnswer(Integer content) {
        super(content);
    }
}
