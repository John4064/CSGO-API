
# Counter Strike Global Offensive HLTV-Api

A Rest API for CS:GO professional matches through match data gathered by HLTV.

## Badges

Add badges from somewhere like: [shields.io](https://shields.io/)

[![MIT License](https://img.shields.io/apm/l/atomic-design-ui.svg?)](https://github.com/tterb/atomic-design-ui/blob/master/LICENSEs)
[![GPLv3 License](https://img.shields.io/badge/License-GPL%20v3-yellow.svg)](https://opensource.org/licenses/)
[![AGPL License](https://img.shields.io/badge/license-AGPL-blue.svg)](http://www.gnu.org/licenses/agpl-3.0)


## API Reference

#### Get all items

```http
  GET /api/items
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `api_key` | `string` | **Required**. Your API key |

#### Get item

```http
  GET /api/items/${id}
```

| Parameter | Type     | Description                       |
| :-------- | :------- | :-------------------------------- |
| `id`      | `string` | **Required**. Id of item to fetch |

#### add(num1, num2)

Takes two numbers and returns the sum.


## Acknowledgements

 - [Spring Boot](https://docs.spring.io/spring-boot/docs/current/reference/htmlsingle/)


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

