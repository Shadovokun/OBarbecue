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

	@SqlUpdate("create table Commentaire (contenu varchar(1000), dat varchar(50), mail varchar(50), valide integer, note integer check (note>-1), check (note<6) ,  PRIMARY KEY (contenu,mail))")
    void createCommentaireTable();
	
	 @SqlUpdate("insert into Commentaire (contenu,dat,mail,valide,note) values (:contenu, :dat, :mail,:valide, :note)")
	 @GetGeneratedKeys
	 int insertCommentaire(@BindBean() Commentaire com);
	 
	 @SqlQuery("select * from Commentaire")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	  List<Commentaire> findByAll();
	 
	 @SqlUpdate("drop table if exists Commentaire")
	 void dropCommentaireTable();
	 
	 @SqlQuery("select * from Commentaire")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 List<Commentaire> all();
	 
	 @SqlQuery("select * from Commentaire where contenue like :contenu")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 List<Commentaire> findByContenu(@Bind("contenu") String contenu);
	 
	 @SqlQuery("select * from Commentaire where valide = 1")
	 @RegisterMapperFactory(BeanMapperFactory.class)
	 List<Commentaire> allValide();
	 
	 @SqlUpdate("Update Commentaire set valide = 1 , where contenu = :contenue and mail = :mail ")
	 void valideCommentaire(@Bind("contenu") String contenu,@Bind("mail") String mail);

	 void close();
}
