package fr.iutinfo.skeleton.api;

import java.util.List;

import org.skife.jdbi.v2.sqlobject.Bind;
import org.skife.jdbi.v2.sqlobject.BindBean;
import org.skife.jdbi.v2.sqlobject.GetGeneratedKeys;
import org.skife.jdbi.v2.sqlobject.SqlQuery;
import org.skife.jdbi.v2.sqlobject.SqlUpdate;
import org.skife.jdbi.v2.sqlobject.customizers.RegisterMapperFactory;
import org.skife.jdbi.v2.tweak.BeanMapperFactory;

public interface CommentaireDAO {

	@SqlUpdate("create table Commentaire (id integer primary key autoincrement,contenu varchar(500), dat varchar(50), mail varchar(50), valide integer, note integer check (note>-1), check (note<6))")
    void createCommentaireTable();
	
	 @SqlUpdate("insert into Commentaire (id,contenu,dat,mail,valide,note) values (:id, :contenu, :dat, :mail,:valide, :note)")
	 @GetGeneratedKeys
	 int insertCommentaire(@BindBean() Commentaire com);
	 
	 @SqlQuery("select * from Commentaire where id = :id")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 Commentaire findByName(@Bind("id") String id);
	 
	 @SqlQuery("select * from Commentaire")
	  @RegisterMapperFactory(BeanMapperFactory.class)
	  List<Commentaire> findByAll();
	 
	 @SqlUpdate("drop table if exists Commentaire")
	 void dropCommentaireTable();
	 
	 @SqlQuery("select * from Commentaire order by id")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 List<Commentaire> all();
	 
	 @SqlQuery("select * from Commentaire where id = :id")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 Commentaire findById(@Bind("id") int id);
	 
	 @SqlQuery("select * from Commentaire where valide = :valide")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 List<Commentaire> allValide(@Bind("valide") int valide);

	 void close();
}
