package com.interview.amazon.Model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
public class TwoLists {
    List<Integer> listOne;
    List<Integer> listTwo;
}
