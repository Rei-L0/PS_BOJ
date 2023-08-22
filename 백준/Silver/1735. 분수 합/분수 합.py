from math import lcm, gcd

x, y = map(int, input().split())
a, b = map(int, input().split())

bunmo = lcm(y, b)
bunja = x * (bunmo // y) + a * (bunmo // b)

while gcd(bunja, bunmo) != 1:
    x = gcd(bunja, bunmo)
    bunja //= x
    bunmo //= x

print(f"{bunja} {bunmo}")
