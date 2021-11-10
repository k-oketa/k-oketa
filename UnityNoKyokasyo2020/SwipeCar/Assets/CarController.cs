using System.Collections;
using System.Collections.Generic;
using UnityEngine;

public class CarController : MonoBehaviour
{
    private float speed = 0f;
    private Vector3 startPosition;
    
    // Start is called before the first frame update
    void Start()
    {
        
    }

    // Update is called once per frame
    void Update()
    {
        if (Input.GetMouseButtonDown(0))
        {
            this.startPosition = Input.mousePosition;
        }
        else if (Input.GetMouseButtonUp(0))
        {
            var endPosition = Input.mousePosition;
            var swipeLength = endPosition.x - this.startPosition.x;

            this.speed = swipeLength / 500.0f;
        }
        
        transform.Translate(this.speed, 0, 0);
        this.speed *= 0.98f;
    }
}
