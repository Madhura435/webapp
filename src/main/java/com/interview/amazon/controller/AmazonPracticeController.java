package com.interview.amazon.controller;

import com.interview.amazon.Model.TwoLists;
import com.interview.amazon.service.AmazonPracticeService;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.util.CollectionUtils;
import org.springframework.web.bind.annotation.*;

import java.util.*;
import java.util.stream.Collectors;

import static org.apache.commons.lang3.math.NumberUtils.min;

@RestController
@RequestMapping("/amazon")
public class AmazonPracticeController {
    @Autowired
    private AmazonPracticeService amazonPracticeService;

    @GetMapping(value = "/missing", produces = MediaType.APPLICATION_JSON_VALUE)
    public int missingelementInList(@RequestParam(value = "start") int start,
                                    @RequestParam(value = "end") int end) {
        return amazonPracticeService.MissingElementInList(start, end);
    }


    @GetMapping(value = "/sum-in-givenInteger", produces = MediaType.APPLICATION_JSON_VALUE)
    public boolean sumoftwointegersisequaltothegivenvalue(@RequestBody List<Integer> list,
                                                          @RequestParam(value = "value") int value) {
        return amazonPracticeService.sumoftwointegersisequaltothegivenvaluet(list, value);
    }

    @GetMapping(value = "/merge", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> mergeTwoListsResultsAsSortedList(@RequestBody TwoLists twoLists
    ) {
        twoLists.getListOne().addAll(twoLists.getListTwo());
        Collections.sort(twoLists.getListOne());
        //Collections.reverse(twoLists.getListOne());
        return twoLists.getListOne();
    }


    @GetMapping(value = "/reverse", produces = MediaType.APPLICATION_JSON_VALUE)
    public String reverseTheCharactersInEachWordInString(@RequestBody String string
    ) {
        String[] y = string.split(" ");
        return Arrays.stream(y).map(n -> StringUtils.reverse(n)).
                collect(Collectors.joining(" "));
    }

    @GetMapping(value = "/collections", produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Integer> AllMethodsInCollection(@RequestBody List<Integer> integerList
    ) {
        // Collections.reverse(integerList);//  = reverse the list
        Collections.sort(integerList, Collections.reverseOrder());//sorting reverse order
        Queue<int[]> q = new ArrayDeque<>();
        return integerList;
    }

    @GetMapping(value = "/reduce", produces = MediaType.APPLICATION_JSON_VALUE)
    public Integer filterReduce(@RequestBody List<Integer> integerList
    ) {
        return integerList.stream().reduce(2,(ans,i)-> min(ans+i));
    }






    @GetMapping(value = "/amazonq", produces = MediaType.APPLICATION_JSON_VALUE)
    public int AmazonCodingQuestion(@RequestBody List<List<Integer>> integerList
    ) {
        return minimumDistance(integerList);
    }

    private int minimumDistance(List<List<Integer>> grid) {
        if (CollectionUtils.isEmpty(grid) )
        {
            return -1;
        }

        Set<String> visited = new HashSet<>();
        Queue<int[]> q = new ArrayDeque<>();
        q.add(new int[]{0, 0});
        visited.add("0,0");
        int distance = 0;
        int[][] moves = {{0, 1}, {0, -1}, {-1, 0}, {1, 0}};
        while (!q.isEmpty()) {
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int[] point = q.remove();
                if (grid.get(point[0]).get(point[1]) == 9)
                    return distance;
                for (int[] move : moves) {
                    int x = point[0] + move[0];
                    int y = point[1] + move[1];
                    if (x >= 0 && x < grid.size() && y >= 0 && y < grid.get(0).size() &&
                            grid.get(x).get(y) != 0 && !visited.contains(x + "," + y)) {
                        q.add(new int[]{x, y});
                        visited.add(x + "," + y);
                    }
                }
            }
            distance++;
        }
        return -1;
    }

}
