
# Counter Strike Global Offensive HLTV-Api

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

## Acknowledgements

 - [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)
 - [HLTV](https://www.hltv.org/)


## Documentation

[Documentation](https://linktodocumentation)


## Roadmap

- [] Base Functionality
  - [] Full Match Search
  - [] Advanced Match Breakdown
  - [] Documentation Completion
- [] Automation
  - [] Automated Webscraping for HLTV Match Data
  - [] Connection to database to upload data
- [] Server
  - [] Physical server setup


## Contributing

Contributions are always welcome!

See `contributing.md` for ways to get started.

Please adhere to this project's `code of conduct`.


## Support

For support, create a pull request or email jparkhurst120@gmail.com


## Authors

- [John Parkhurst](https://www.github.com/John4064)


## License

[MIT](https://choosealicense.com/licenses/mit/)

