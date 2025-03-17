
# Spring Music API

Une API parmi tant d’autres, mais avec du rythme ! Projet Spring mettant en place une API REST avec un système d'authentification, de bounce de requêtes et de scrap.
## Installation

Cloner le projet

```bash
  git clone https://github.com/BldNicolas/springMusicAPI
```

Aller dans le dossier du projet

```bash
  cd springMusicAPI
```

Lancer la base de donnée via le dockerfile

```bash
  docker compose up -d --build
```

Lancer WebsiteApplication.java

## Routes API

Pour tester les routes API il faut aller dans `./postman/` afin de trouver la collection et l'environnement nécessaire.

### User

#### Register

```http
  POST /api/users/register
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `String` | Nom d'utilisateur |
| `password` | `String` | Mot de passe |
| `roles` | `JSON` | Roles de l'utilisateur |

Créer un utilisateur avec un ou plusieurs roles.

#### Login

```http
  POST /api/login
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `username` | `String` | Nom d'utilisateur |
| `password` | `String` | Mot de passe |

Connecte un utilisateur.

### Bounce

#### Artist

```http
  GET /artist/{id}/bounce
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id de l'artist que l'on veut bounce |

Récupère les données d'un artist via l'api Deezer.

#### Track

```http
  GET /track/{id}/bounce
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id du morceau que l'on veut bounce |

Récupère les données d'un morceau de musique via l'api Deezer.

### Scrap

#### Artist

```http
  GET /artist/{id}/scrap
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id de l'artist que l'on veut scrap |

Récupère les données d'un artist via l'api Deezer et les enregistre en base. **ATTENTION** on ne peut scrap deux fois le même artiste !

#### Track

```http
  GET /track/{id}/scrap
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id du morceau que l'on veut scrap |

Récupère les données d'un morceau de musique via l'api Deezer et les enregistre en base. **ATTENTION** on ne peut scrap deux fois le même morceau.

### CRUD

#### Artist

```http
  GET /artist/{id}/get
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id de l'artiste que l'on veut récupérer |

Récupère les données d'un artiste de musique en base.

___

```http
  POST /artist/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `idDeezer` | `Integer` | **[unique]** id deezer de l'artiste |
| `name` | `String` | **[unique]** nom de l'artiste |
| `image` | `String` | lien de l'image de l'artiste |
| `nbAlbum` | `Integer` | nombre d'album de l'artiste |

Insère en base un artiste. **ATTENTION** les paramètres marqué comme [unique] sont unique.

___

```http
  POST /artist/{id}/update
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id de l'artiste en base |
| `idDeezer` | `Integer` | **[unique]** id deezer de l'artiste |
| `name` | `String` | **[unique]** nom de l'artiste |
| `image` | `String` | lien de l'image de l'artiste |
| `nbAlbum` | `Integer` | nombre d'album de l'artiste |

Met à jour en base un artiste. **ATTENTION** les paramètres marqué comme [unique] sont unique.

___

```http
  DELETE /artist/1/delete
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id de l'artiste en base |

Supprime l'artiste en base.

#### Track

```http
  GET /track/{id}/get
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id du morceau que l'on veut récupérer |

Récupère les données d'un morceau de musique en base.

___

```http
  POST /track/create
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `idDeezer` | `Integer` | **[unique]** id deezer du morceau |
| `title` | `String` | titre du morceau |
| `link` | `String` | lien deezer du morceau |
| `duration` | `Integer` | durée du morceau |
| `rank` | `Integer` | rang du morceau |
| `artistDTO` | `JSON` | artiste qui a fait le morceau |
| `artistDTO.idDeezer` | `Integer` | **[unique]** id deezer de l'artiste |
| `artistDTO.name` | `String` | nom de l'artiste |
| `artistDTO.link` | `String` | lien de l'artiste |

Insère en base un morceau et si l'artiste n'existe pas, va scrapper l'artiste. **ATTENTION** les paramètres marqué comme [unique] sont unique.

___

```http
  POST /track/{id}/update
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id du morceau en base |
| `idDeezer` | `Integer` | **[unique]** id deezer du morceau |
| `title` | `String` | titre du morceau |
| `link` | `String` | lien deezer du morceau |
| `duration` | `Integer` | durée du morceau |
| `rank` | `Integer` | rang du morceau |
| `artistDTO` | `JSON` | artiste qui a fait le morceau |
| `artistDTO.idDeezer` | `Integer` | **[unique]** id deezer de l'artiste |
| `artistDTO.name` | `String` | nom de l'artiste |
| `artistDTO.link` | `String` | lien de l'artiste |

Met à jour en base un morceau. **ATTENTION** les paramètres marqué comme [unique] sont unique.

___

```http
  DELETE /track/1/delete
```

| Parameter | Type     | Description                |
| :-------- | :------- | :------------------------- |
| `id` | `Integer` | id du morceau en base |

Supprime le morceau en base.
