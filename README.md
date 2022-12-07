# polaris

Problème de mapping enum 

Appeler /user dans UserCOntroller puis /ticket puis /item dans TicketController
plante car un problème de création du contructeur de l'enum Categorie (Enum Statut Ok ?) 
plante au moment de récupérer l'objet ticket dans tiketcontroller ...

en BDD la table Status est liée à Ticket 
la table Category est liée à Ticket et Item

Quand un item est créer il est censé prendre la catégory de l'item qui lui est lié 
