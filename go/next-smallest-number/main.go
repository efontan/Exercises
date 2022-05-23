package main

import (
	"fmt"
)

func main() {
	a := []int{3, 4, 6, 9, 10, 12, 14, 15, 17, 19, 21}
	s := NewSmallerSearch()

	fmt.Printf("Next smaller number for f(a, 12): %d\n", s.Smaller(a, 12))
	fmt.Printf("Next smaller number for f(a, 13): %d\n", s.Smaller(a, 13))
	fmt.Printf("Next smaller number for f(a, 2): %d\n", s.Smaller(a, 2))
	fmt.Printf("Next smaller number for f(a, 22): %d\n", s.Smaller(a, 22))
	fmt.Printf("Next smaller number for f(a, 3): %d\n", s.Smaller(a, 3))
	fmt.Printf("Next smaller number for f(a, 21): %d\n", s.Smaller(a, 21))
	fmt.Printf("Next smaller number for f([], 1): %d\n", s.Smaller([]int{}, 1))
	fmt.Printf("Next smaller number for f(nil, 1): %d\n", s.Smaller(nil, 1))
}

type smallerSearch interface {
	Smaller(numbers []int, targetNumber int) int
}

func NewSmallerSearch() smallerSearch {
	return &smallerBinary{}
}

//
// Brute forced solution
//
type smallerLinear struct {
}

func (sl *smallerLinear) Smaller(numbers []int, targetNumber int) int {
	result := -1
	if len(numbers) == 0 {
		return result
	}

	for i := 0; i < len(numbers); i++ {
		if numbers[i] == targetNumber {
			return numbers[i]
		} else if numbers[i] > targetNumber {
			return result
		} else {
			result = numbers[i]
		}
	}
	return result
}

//
// Binary Search solution (assuming the slice is sorted, otherwise need to sort first)
//
type smallerBinary struct {
}

func (sb *smallerBinary) Smaller(numbers []int, targetNumber int) int {
	if len(numbers) == 0 {
		return -1
	}

	if numbers[0] == targetNumber {
		return targetNumber
	}

	result := -1
	left := 0
	right := len(numbers) - 1

	for left <= right {
		mid := (left + right) / 2
		if targetNumber == numbers[mid] {
			return targetNumber
		} else if targetNumber > numbers[mid] {
			result = numbers[mid]
			left = mid + 1
		} else {
			right = mid - 1
		}
	}

	return result
}
