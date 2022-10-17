package com.interview.amazon.service;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@Service
@Slf4j
public class AmazonPracticeService {


    public int MissingElementInList(int start, int end) {
        List<Integer> integerList = IntStream.rangeClosed(start, end).boxed().collect(Collectors.toList());
        integerList.remove((new Random()).nextInt(start) + 1);
        int missingSum = integerList.stream().mapToInt(Integer::intValue).sum();
        int actualSum = (end - start + 1) * (start + end) / 2;
        ;



        return actualSum - missingSum;
    }

    int MissingNumber(int array[], int n) {
//        // Your Code Here
          List<Integer> integerList=Arrays.stream(array).boxed().
                    collect(Collectors.toList());
//            for(int i=1;i<=n;i++) {
//                if (!list.contains(i)) {
//                    return i;
//                }
//            }
//        AtomicInteger count=new AtomicInteger(0);
//        return Arrays.stream(array).filter(number->number!=count.getAndIncrement()+1).findFirst().getAsInt();
//
//        List<Integer> list=new Arrays.asList(array);
//        for(int i=1;i<=n;i++)
//        {
//            if(!list.contains(i))
//            {
//                return i;
//            }
//        }
        int missingSum = integerList.stream().mapToInt(Integer::intValue).sum();
        int actualSum=Arrays.stream(array).sum();
        return actualSum-missingSum;

    }
    public boolean sumoftwointegersisequaltothegivenvaluet(List<Integer> list, int value) {
//      AtomicBoolean b= new AtomicBoolean(false);
//        list.stream().forEach(n -> {
//            list.stream().forEach(n1->{
//                if(value==(n+n1))
//                {
//                    b.set(true);
//                }
//
//            });
//        });
        Optional<Integer> u = list.stream().filter(n -> list.stream().anyMatch(n1 -> (n1 + n) == value)).findFirst();
        Collections.sort(list);
        return !u.isEmpty();
    }



}
