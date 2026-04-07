package com.course.spring_reactor_demo;


import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.Duration;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

@SpringBootApplication
public class SpringReactorDemoApplication  implements CommandLineRunner {

	private static final Logger logger = LoggerFactory.getLogger(SpringReactorDemoApplication.class);
	private static List<String> dishes= new ArrayList<>();


	public static void main(String[] args) {
		SpringApplication.run(SpringReactorDemoApplication.class, args);
	}

	private void createMono(){
		Mono<String> f1 = Mono.just("Hello");
		// f1.subscribe(x->System.out.println(x));
		// f1.subscribe(System.out::println);
		f1.subscribe(logger::info);

		Mono.just("Hello 2").subscribe(logger::info); //13:05
	}

	private void createFlux(){
		Flux<String> fx1 = Flux.fromIterable(dishes);
		// fx1.subscribe(logger::info);

		fx1.collectList().subscribe(list -> logger.info(list.toString())); // Genera un Mono<List<String>> desde un flux
	}

	private void m1doOnNext(){
		Flux<String> fx1 = Flux.fromIterable(dishes);
		fx1.doOnNext(x-> logger.info("element "+x)).subscribe(); // el operador doOnNext es para impresion de valores, nternamente tiene un void
	}

	private void m2Map(){
		Flux<String> fx1 = Flux.fromIterable(dishes);
		fx1.map(String::toUpperCase)
				.doOnNext(logger::info)
				.subscribe();
	}

	private void m3FlatMap(){
		Mono.just("hello").map(x-> 33).subscribe(x->logger.info(" sasa "+x));
		Mono.just("hello").map(x-> Mono.just(33)).subscribe(x->logger.info(" sasa "+x)); // comprimido
		Mono.just("hello").flatMap(x-> Mono.just(33)).subscribe(x->logger.info(" sasa "+x)); // me muestra el valor 33
	}

	private void m4Range(){
		Flux<Integer> fx1 = Flux.range(0,10);
		fx1.doOnNext(e-> logger.info("{}", e)).subscribe();
	}

	private void m5delayElements() throws InterruptedException {
		Flux.range(0,20)
				.delayElements(Duration.ofSeconds(1)) // proceso que demora mas que el hilo main
				.doOnNext(e-> logger.info("{}",e))
				.subscribe();

		Thread.sleep(22000);
	}

	private void m6ZipWith(){
		List<String> customers = new ArrayList<>();
		customers.add("cliente a");
		customers.add("cliente b");
		customers.add("cliente c");
		customers.add("cliente d");

		Flux<String> fx1 = Flux.fromIterable(dishes);
		Flux<String> fx2 = Flux.fromIterable(customers);

		fx1.zipWith(fx2,(d,c)-> d+"-"+c)
				.doOnNext(logger::info)
				.subscribe();
	}

	private void m7Merge() throws InterruptedException {
		List<String> customers = new ArrayList<>();
		customers.add("cliente a");
		customers.add("cliente b");
		customers.add("cliente c");
		customers.add("cliente d");

		Flux<String> fx1 = Flux.fromIterable(dishes);
		Flux<String> fx2 = Flux.fromIterable(customers);

		Mono<Integer> m1 = Mono.just(1);

		Flux.merge(fx1,fx2,m1,m1)
				//.delayElements(Duration.ofSeconds(2))
				.doOnNext(e-> logger.info("{}",e))
				.subscribe();

		//Thread.sleep(22000);
	}

	private void m8Filter(){
		List<String> customers = new ArrayList<>();
		customers.add("cliente a");
		customers.add("cliente b");
		customers.add("cliente c");
		customers.add("cliente d");

		Flux <String > fx1 = Flux.fromIterable(customers);
		Predicate<String> predicate = e -> e.endsWith("d");

		fx1.filter(predicate)
				.doOnNext(logger::info)
				.subscribe();

	}

	private void m9TakeLast(){
		Flux <String > fx1 = Flux.fromIterable(dishes);
		fx1.takeLast(2) // toma el flujo de datos desde el final
				.doOnNext(logger::info)
				.subscribe();
	}


	private void m10Last(){
		Flux <String > fx1 = Flux.fromIterable(dishes);
		fx1.take(1)  // toma el flujo de datos desde el inicio
				.doOnNext(logger::info)
				.subscribe();
	}

	private void m11DefaultEmpty (){

		dishes = new ArrayList<>();
		Flux <String > fx1 = Flux.fromIterable(dishes);

		fx1.map(e-> "dishe "+e)
				.defaultIfEmpty("Empty")
				.doOnNext(logger::info)
				.subscribe();
		
	}

	private void m12Error(){
		Flux <String > fx1 = Flux.fromIterable(dishes);

		fx1.doOnNext(
				e->{
					throw new ArithmeticException("BAD OPERATION");
				})
				// .onErrorReturn("TRY EGAIN")
				.onErrorMap(e-> new Exception(e.getMessage()))
				.subscribe(logger::info);
	}

	@Override
	public void run(String... args) throws Exception {
		// createMono();
		dishes.add("dish a");
		dishes.add("dish b");
		dishes.add("dish c");
		// createFlux();
		// m1doOnNext();
		// m2Map();
		// m3FlatMap();
		// m4Range();
		// m5delayElements();
		// m6ZipWith();
		// m7Merge();
		// m8Filter();
		// m9TakeLast();
		// m10Last();
		// m11DefaultEmpty();
		m12Error();
	}
}
