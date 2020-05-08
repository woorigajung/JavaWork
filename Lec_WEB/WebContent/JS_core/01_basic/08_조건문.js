// if ~ else
// if ~ else if ~ else ..
// JAVA, C 언어와 구조 동일

a = 100

if(a + 1 > 100){  // 참 판정
    let a = 10;
    console.log('if 안의 a 값은', a);  // 10
}

// 조건식에서 참거짓 판정시!

// Falsy : 조건식에서 거짓으로 평가
// false, 0, '', null, undefined, NaN   <-- 'Falsy 한 값'이라 한다

// Truthy : 조건식에서 참으로 평가
// true, 37, 'Mark', {}, []   <-- 'Truthy 한 값' 이라 한다


function print(data){
    if(data){ // 참(Truthy) 거짓(Falsy) 판정
        console.log(data, typeof data, '-- Truthy');
    } else {
        console.log(data, typeof data, '-- Falsy');
    }
}

print(true)
print(false)
print(100)  // T
print(0)  // F
print(-1)  // T 
print('hello') // T
print("") // F
print([10, 20, 30])  // T
print([])  // T  , ★ 파이썬 과는 다르다!
print({'name' : 'John', 'age': 32})  // T
print({}) // T  , ★ 파이썬 과는 다르다!
print(null)
print(undefined)
print(NaN)
console.log(100 / 0)  // Infinity
print(100 / 0)  // T

print()  // 호출시 전달인자 없으면 undefined 값으로 동작함


console.log()
// Falsy 값에 ! 결과 => true (boolean)
console.log(!undefined)
console.log(!null)
console.log(!0)
console.log(!"")
console.log(!NaN)

// Truthy 값에 ! 결과 => false (boolean)
console.log(!3)
console.log(!"Hello")
console.log(!" ")
console.log(![10, 20, 30])
console.log(![])
console.log(!{})


// Truthy, Falsy 판정결과--> boolean 
// 1. 삼항연산자 사용
let value = {'a' : 100}
let isTrue = value ? true : false;
console.log('isTrue =', isTrue, typeof isTrue)

// 2. !! 사용하면 가능!
isTrue = !!value;
console.log('isTrue =', isTrue, typeof isTrue)


console.log()

function printName(person){
    console.log('이름은', person.name)
}

let myBrother = {name : "John"}

printName(myBrother)
// printName()  // 에러다  undefined 값이 person 에 넘겨짐

// 함수 정의할때 매개변수 체크 필요
function printName(person){
    
    // 매개변수 null check .
    //if(person === undefined || person === null) return;
    if(!person) return;   // 간단하게 해결

    console.log('이름은', person.name)
}

printName(myBrother);
printName();


console.log("\n프로그램종료\n\n\n\n\n\n\n\n\n\n\n");











