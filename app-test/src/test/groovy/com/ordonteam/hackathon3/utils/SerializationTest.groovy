package com.ordonteam.hackathon3.utils

import com.ordonteam.hackathon3.model.Wall
import com.ordonteam.hackathon3.model.Dimension
import pl.polidea.robospock.RoboSpecification

class SerializationTest extends RoboSpecification{

    def "Paint should be serializable"(){
        Wall wall = new Wall(new Dimension(1, 1))
        Wall unpersistedWall

        when:
        new ByteArrayInputStream(persist(wall)).withObjectInputStream { ObjectInputStream stream ->
            unpersistedWall = stream.readObject() as Wall
        }

        then:
        unpersistedWall == wall

    }

    static byte[] persist(Object objectToPersist) {
        ByteArrayOutputStream byteOutputStream = new ByteArrayOutputStream();
        byteOutputStream.withObjectOutputStream { ObjectOutputStream stream ->
            stream.writeObject(objectToPersist)
        }
        return byteOutputStream.toByteArray()
    }

}
