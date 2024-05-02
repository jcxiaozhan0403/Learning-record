import requests

headers = {
    "User-Agent": "Mozilla/5.0 (Windows NT 10.0; Win64; x64) AppleWebKit/537.36 (KHTML, like Gecko) Chrome/124.0.0.0 Safari/537.36",
    "Referer": "https://temp-mail.org/",
    "Authorization": "Bearer eyJhbGciOiJIUzI1NiIsInR5cCI6IkpXVCJ9.eyJ1dWlkIjoiMzZmNjU1NjllYWEwNGYxYjk4MmE5MTQ4MGJjMjA1MTEiLCJtYWlsYm94IjoiZ2lsaW5lMTg1MUBvY2l1bi5jb20iLCJpYXQiOjE3MTQ1NzY2OTF9.sS3R_OoXex3qyoARNoMK2YGIbijESxsIUtnXrJKyIVI"
}


# str = requests.get("https://web2.temp-mail.org/mailbox",headers = headers)
str = requests.get("https://web2.temp-mail.org/mailbox",headers = headers)

print(str.json())

page = requests.get("https://temp-mail.org/",headers = headers)

print(page)
