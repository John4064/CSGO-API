
# Counter Strike Global Offensive HLTV-API

A Rest API for CS:GO professional matches through match data gathered by HLTV.

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://choosealicense.com/licenses/mit/)



## API Reference

#### Get all matches

```http
  GET /api/findall
```


#### Get match

```http
  GET /api/match/{id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of match to fetch |

#### Get team matches

```http
  GET /api/team/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. Name of team in match |

#### Get matches in competion

```http
  GET /api/comp/{name}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `name`      | `string` | **Required**. Name of tournament |

#### Get matches of same type

```http
  GET /api/type/{typename}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `typename`      | `string` | **Required**. Type of match(bo3,bo5) |

#### Get X # of most recent matches

```http
  GET /api/top/{number}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `number`      | `int` | **Required**. # of matches you want? |

#### Add matches to the database

```http
  POST /admin/add/
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `HltvMatch`      | `json String` | **Required** Match    |
```json
{   
    "teamA": "fnatic",
    "teamB": "NIP",
    "url": "https://hltv.org/results/",
    "competition": "bo3",
    "typeofmatch": "comp",
    "scoreA": 2,
    "scoreB": 1,
    "matchid": 532323
} 
```

## Web Scraping
The second aspect of this project is the web scraping script to gather all potential matches on hltv.org/results. Check the webscrape directory to properly view that code. More documentation/tests on the process in the near future.
## Acknowledgements

 - [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
 - [HLTV](https://www.hltv.org/)


## Documentation

[Documentation](https://linktodocumentation)


## Roadmap

- [x] Base Functionality
  - [x] Full Match Search
  - [x] Advanced Match Breakdown
  - [x] Documentation Completion
- [] Automation
  - [x] Automated Web scraping for HLTV Match Data
  - [x] Connection to database to upload data
  - [] Bug fix error regarding incomplete data for 2% of matches
- [] Server
  - [x] Physical server setup
  - [] Port Existing SQL database to server
- [] Potential Future
  - [] Setup a Web App to interact with the match data
  - [] Data Analysis on said CS: GO matches
  - [] Make API public use/setup auth key

# Setup & Getting Started

Check example configs folder for example MySql commands to replicate the database being used as well as a basic application.properties needed for the api to function.
If you would like to run locally follow these instructions.

## Steps
1. First set up a mysql database, create a default empty table with the command listed in the example-configs.
2. Next modify the apis application-properties providing springboot with the necessary configurations fielded with the username, password, and server IP.
3. Then run the spring boot api making sure it is up and running.
4. Next execute the web scraping script found in the web scrape folder make sure to specify the correct end point in the uploadToDb method.
5. You can test if the database was properly populate using the sql command below or sending a get request to the api(see above for sample api requests).

```sql
select * from hltv_match;
```

<!-- CONTRIBUTING -->
## Contributing

Contributions are what make the open source community such an amazing place to learn, inspire, and create. Any contributions you make are **greatly appreciated**.

If you have a suggestion that would make this better, please fork the repo and create a pull request. You can also simply open an issue with the tag "enhancement".
Don't forget to give the project a star! Thanks again!

1. Fork the Project
2. Create your Feature Branch (`git checkout -b feature/AmazingFeature`)
3. Commit your Changes (`git commit -m 'Add some AmazingFeature'`)
4. Push to the Branch (`git push origin feature/AmazingFeature`)
5. Open a Pull Request



## Support

For support, create a pull request or email jparkhurst120@gmail.com


## Authors

- [John Parkhurst](https://www.github.com/John4064)


## License

[MIT](https://choosealicense.com/licenses/mit/)

