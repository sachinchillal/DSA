function romanToInt(s: string): number {
  const special = ["IV", "IX", "XL", "XC", "CD", "CM"]
  let ns = s;
  special.forEach((sp, i) => {
    // replace all
    ns = ns.replace(new RegExp(sp, "g"), i.toString());
  })
  console.log(s, ns)
  let sL = ns.split("")

  let l: number[] = []
  const O: {
    [key: string]: number
  } = {
    "I": 1,
    "V": 5,
    "X": 10,
    "L": 50,
    "C": 100,
    "D": 500,
    "M": 1000,
    0: 4, 1: 9, 2: 40, 3: 90, 4: 400, 5: 900
  }
  sL.forEach((i) => {
    l.push(O[i]);
  })
  console.log(sL)
  console.log(l)
  let sum = l.reduce((a, c) => a + c, 0)
  return sum;
};
console.log(romanToInt("III")) // 3
console.log(romanToInt("IV")) // 4
console.log(romanToInt("IVIV")) // 8
console.log(romanToInt("IX")) // 9
console.log(romanToInt("LVIII")) // 58
console.log(romanToInt("MCMXCIV")) // 1994

export const A = 1;