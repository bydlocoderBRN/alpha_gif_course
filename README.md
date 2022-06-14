## Инструкция по запуску

Проект лежит на ветке master!

Если у вас установлен Docker:
- Откройте консоль
- Введите по очереди следующие комманды

> docker pull chechkysh/alpha_gif_course:1.1

> docker run -p 8081:8081 chechkysh/alpha_gif_course:1.1 java -jar build/libs/GifCourse-0.0.1-SNAPSHOT.jar

Если Докера нет:

- Клонируйте этот репозиторий (ветку master)
- Из корневой папки выполните следующие комманды: 

> gradlew build

> java -jar build/libs/GifCourse-0.0.1-SNAPSHOT.jar

После этого сервер будет запущен 

## Endpoint

Ссылка: http://localhost:8081/alpha/exchange_gif/{код_валюты}

Метод: GET

Переменные пути: String {код_валюты} - почти любой код валюты (прим. RUB, EUR, USD)

Тело ответа: 

{

    "type": String
    
    "id": String
    
    "url": String
    
    "slug": String
    
    "bitly_gif_url": String
    
    "bitly_url": String
    
    "embed_url": String
    
    "username": String
    
    "source": String
    
    "title": String
    
    "rating": String
    
    "content_url": String
    
    "source_tld": String
    
    "source_post_url": String
    
}

Заголовки ответа: 
- Content-Type : application/json
- Transfer-Encoding : chunked
- Date 
- Keep-Alive : timeout=60
- Connection: keep-alive

Пример:

Запрос: 

Метод: GET

URL: http://localhost:8081/alpha/exchange_gif/RUB 

Переменные пути: "RUB"

Ответ: 

{

    "type": "gif",
    
    "id": "W1oEFLw9mNWFqu9VRO",
    
    "url": "https://giphy.com/gifs/HBOMax-hbo-max-dc-universe-doom-patrol-W1oEFLw9mNWFqu9VRO",
    
    "slug": "HBOMax-hbo-max-dc-universe-doom-patrol-W1oEFLw9mNWFqu9VRO",
    
    "bitly_gif_url": "https://gph.is/g/aj7bqdo",
    
    "bitly_url": "https://gph.is/g/aj7bqdo",
    
    "embed_url": "https://giphy.com/embed/W1oEFLw9mNWFqu9VRO",
    
    "username": "HBOMax",
    
    "source": "https://hbom.ax/DCTray",
    
    "title": "Dc Universe Money GIF by HBO Max",
    
    "rating": "g",
    
    "content_url": "",
    
    "source_tld": "hbom.ax",
    
    "source_post_url": "https://hbom.ax/DCTray"
    
}


#### ВНИМАНИЕ!

Из - за того, что АПИ для курсов валют, которое рекоммендовали использовать в тестовом задании - платное, то для курсов валют используется это АПИ:
https://apilayer.com/marketplace/currency_data-api#details-tab
