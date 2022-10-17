package com.interview.amazon;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

@SpringBootApplication
public class AmazonApplication implements CommandLineRunner {

	public static void main(String[] args) {
		SpringApplication.run(AmazonApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		List<Integer> integerList= IntStream.rangeClosed(1,100).boxed().collect(Collectors.toList());
		integerList.remove(88);
		//Integer[] n=integerList.toArray(new Integer[0]);
		//Arrays.stream(n).forEach(h->System.out.print(h));



	}
}
