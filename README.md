# citoyen_back

association :*********************************************
- lister les Association : GET > http://localhost:8080/associations
- add = Post=>/admin/AddAssociation
{
	"adresse1":"mhamid",
	"adresse2":"mhamid",
	"email":"mohcne@gmail.com",
	"tel":"0626226265",
	"description":"mdfvkmdflv",
	"domaine":"sport",
	"image":"jnvijnfv",
	"localisation":"-455",
	"mdp":"hhhh",
	"nom":"amal",
	"ville":"marrakech"
}
- delete : DELETE > http://localhost:8080/associations/1 => 1 is the id
- update : PUT > http://localhost:8080/associations/1 

Recompence : **********************************************
- lister les recompences : GET > http://localhost:8080/recompences
- add = Post=>/admin/AddRecompence
{
	"titre":"boooo",
	"description":"jjjo",
	"date":"yyyy-MM-dd HH:mm:ss.SSSSSS",
	"nombre":"9",
	"score":"150"
}
- delete : DELETE > http://localhost:8080/recompences/1
- update : PUT > http://localhost:8080/recompences/1

Activite :
- Lister les Activites  : GET http://localhost:8080/activites
- Search by Id > url :GET  http://localhost:8080/activites/1
- Search by Status > url : GET http://localhost:8080/activites/search/ByStatus?status=refused

- Accept Activite : POST http://localhost:8080/ActionOnActivite?id=1&status=accepted&score=12
- refuse Activite : POST http://localhost:8080/ActionOnActivite?id=1&status=refused 