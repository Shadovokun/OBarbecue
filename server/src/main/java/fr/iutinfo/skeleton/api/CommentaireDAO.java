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

	@SqlUpdate("create table Commentaire (id integer primary key autoincrement, contenu varchar(500), date varchar(50), mail varchar(50), note integer check (note>-1), check (note<6)) ")
    void createCommentaireTable();
	
	 @SqlUpdate("insert into Commentaire (id,contenu,date,mail,note) values (:id, :contenu, :date, :mail, :note)")
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
	 
	 @SqlQuery("select * from users where id = :id")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 Commentaire findById(@Bind("id") int id);

	 void close();
}
