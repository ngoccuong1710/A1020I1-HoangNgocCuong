const list: number[] = [1, 2, 3];
const categories: Array<string> =
    ['Sport', 'IT', 'Car'];
console.log('list');

list.forEach((num) =>
    console.log(num.toFixed(2))
);

console.log('categries');
categories.forEach((str) =>
    console.log(str.includes('a'))
);


const listSquare = list.map(num => num * num);
console.log(listSquare)


const result = categories.filter(str => str.length > 2)
console.log(result);

let x: [string, number];
x = ["hello", 10];
console.log(x[0].substr(1));

x[3] = "world";
x[5] = 100.25;
console.log(x[5].toString());
