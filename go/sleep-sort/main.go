package main

import (
	"fmt"
	"sync"
	"time"
)

func sleepSort(numbers []int, wg *sync.WaitGroup) {
	for _, n := range numbers {
		go func(n int) {
			time.Sleep(time.Duration(n) * time.Millisecond)
			fmt.Println(n)
			wg.Done()
		}(n)
	}
}

func main() {
	numbers := []int{12, 4, 8, 100, 1, 6, 7, 19, 5}

	var wg sync.WaitGroup
	wg.Add(len(numbers))

	sleepSort(numbers, &wg)

	wg.Wait()
}
